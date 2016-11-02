package com.alekseysamoylov.serviceiii.util;

import lombok.extern.apachecommons.CommonsLog;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;


/**
 * Тип Hibernate для работы с Enum классами, реализующими {@link CustomIntegerEnum}
 */
@CommonsLog
public class CustomIntegerEnumType extends CustomEnumType {

    /**
     * This method maps the database mapping
     */
    @Override
    public int[] sqlTypes() {
        return new int[]{Types.INTEGER};
    }

    /**
     * Recreate the enum from the resultset
     */
    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner) throws HibernateException, SQLException {
        Integer value = rs.getInt(names[0]);
        // Если поле было NULL, то обнуляем значение.
        if (rs.wasNull()) {
            value = null;
        }
        Object returnVal = null;

        try {
            returnVal = recreateEnum(value);
        } catch (IllegalArgumentException e) {
            CustomIntegerEnumType.log.error(e);
        }
        return returnVal;
    }

    /**
     * Fetch the data from enum and set it in prepared statement
     */
    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws HibernateException, SQLException {
        Integer prepStmtVal;

        if (value == null) {
            st.setObject(index, null);
        } else {
            try {
                prepStmtVal = ((CustomIntegerEnum) value).getId();
                st.setInt(index, prepStmtVal);
            } catch (IllegalArgumentException e) {
                CustomIntegerEnumType.log.error(e);
            }
        }
    }

    /**
     * Deep copy method
     */
    @Override
    public Object deepCopy(Object value) throws HibernateException {
        if (value == null)
            return null;
        else {
            CustomIntegerEnum enumVal = (CustomIntegerEnum) value;
            return recreateEnum(enumVal.getId());
        }
    }

    /**
     * Служебный метод для создания элемента Enum по числовому представлению полученному из БД
     *
     * @param value числовое представление элемента
     * @return элемент Enum
     */
    @SuppressWarnings("unchecked")
    public CustomIntegerEnum recreateEnum(Integer value) {
        if (value != null) {
            return EnumUtils.getEnum((Class<? extends CustomIntegerEnum>) returnedClass(), value);
        }
        return null;
    }
}