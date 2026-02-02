package practice;


import java.util.Arrays;
import java.util.stream.Collectors;

public enum EnumTest {
    ID("id"),
    CUSTOMER_NAME("customerName"),
    CUSTOMER_NUMBER("customerNumber"),
    IS_ACTIVE("isActive");

    private final String fieldName;

    EnumTest(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    @Override
    public String toString() {
        return fieldName;
    }

    public static EnumTest fromValue(String value) {
        for (EnumTest attribute : values()) {
            if (attribute.fieldName.equalsIgnoreCase(value)) {
                return attribute;
            }
        }
        throw new IllegalArgumentException("Invalid sorting field: " + value);
    }

    public static void main(String[] args) {
        System.out.println(EnumTest.ID.fieldName);
        System.out.println(EnumTest.fromValue("customerName"));
        System.out.println(Arrays.stream(EnumTest.values()).collect(Collectors.toList()));
    }
}
