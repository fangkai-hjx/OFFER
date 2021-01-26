package juc.day01;

import lombok.Getter;

@Getter
public enum CountryEnum {
    ONE(1,"齐"),
    TWO(2,"楚"),
    THREE(3,"燕"),
    FOUR(4,"赵"),
    FIVE(5,"韩"),
    SIX(6,"魏");
    private Integer num;
    private String country;
    CountryEnum(Integer num, String country){
        this.num = num;
        this.country = country;
    }
    public static CountryEnum foreach_CountryEnum(int index){
        final CountryEnum[] values = CountryEnum.values();
        for (CountryEnum element : values) {
            if(index == element.getNum()){
                return element;
            }
        }
        return null;
    }
}
