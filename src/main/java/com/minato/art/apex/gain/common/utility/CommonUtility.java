package com.minato.art.apex.gain.common.utility;

import java.util.Objects;

public class CommonUtility {
    private CommonUtility() {
    }

    public static String getSimplifiedClassName(Class<?> clazz){
        if (Objects.nonNull(clazz)){
            return clazz.getSimpleName();
        }
        return "UnknownClass";
    }
}
