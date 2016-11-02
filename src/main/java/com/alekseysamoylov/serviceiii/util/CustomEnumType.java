package com.alekseysamoylov.serviceiii.util;

import lombok.Getter;
import lombok.extern.apachecommons.CommonsLog;
import org.hibernate.HibernateException;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.util.Properties;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
@CommonsLog
public abstract class CustomEnumType implements UserType, ParameterizedType {

    /**
     * Реальный Enum класс для которого создан данный экземпляр EnumType
     */
    @Getter
    private Class<?> enumClass;

    /**
     * This method uses the parameter values passed during enum mapping definition
     * and sets corresponding properties defined
     */
    @Override
    public void setParameterValues(Properties parameters) {
        if (parameters != null) {
            String className = parameters.getProperty("enumClassName");

            try {
                Class<?> aClass = Class.forName(className);
                if (aClass.isEnum()) {
                    enumClass = aClass;
                } else {
                    throw new IllegalArgumentException("Parameter enumClassName contains non Enum class");
                }
            } catch (ClassNotFoundException e) {
                CustomEnumType.log.error(e);
            } catch (SecurityException e) {
                CustomEnumType.log.error(e);
            }
        }
    }

    /**
     * This method maps the class for which user type is created
     */
    public Class<?> returnedClass() {
        return enumClass;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return ObjectUtils.nullSafeEquals(x, y);
    }

    /**
     * Fetch the hash code
     */
    @Override
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        Object deepCopy = deepCopy(value);

        if ((deepCopy instanceof Serializable))
            return (Serializable) deepCopy;

        return null;
    }

    @Override
    public Object assemble(Serializable cached, Object owner)
            throws HibernateException {
        return deepCopy(cached);
    }

    @Override
    public Object replace(Object original, Object target, Object owner)
            throws HibernateException {
        return deepCopy(original);
    }

}
