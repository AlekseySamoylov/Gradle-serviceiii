package com.alekseysamoylov.serviceiii.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by alekseysamoylov on 11/12/16.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WorkGroupTitle {
    private Long id;
    private String title;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkGroupTitle that = (WorkGroupTitle) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return title != null ? title.equals(that.title) : that.title == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
