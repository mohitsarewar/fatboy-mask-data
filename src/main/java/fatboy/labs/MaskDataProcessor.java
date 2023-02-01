package fatboy.labs;

import fatboy.labs.annotations.Mask;

import java.lang.reflect.Field;

public class MaskDataProcessor {
    public static void maskData(Object object) {
        for (Field field : object.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Mask.class)) {
                field.setAccessible(true);
                try {
                    field.set(object, field.getAnnotation(Mask.class).value());
                } catch (IllegalAccessException e) {
                    // handle exception
                }
            }
        }
    }
}

