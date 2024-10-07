package tech.reliab.course.toropchida.yartsevvsLab3.utils;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

public class Utils {
    /* Получение случайного числа типа Integer на отрезке [a, b) */
    public static int getRandomIntFromAToB(Integer a, Integer b)
    {
        return (int) (Math.random() * (b - a)) + (a);
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null)
                emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];

        return emptyNames.toArray(result);
    }
}
