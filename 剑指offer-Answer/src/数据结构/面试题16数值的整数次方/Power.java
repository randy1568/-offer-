package 数据结构.面试题16数值的整数次方;

public class Power {

    public double Power2(double base, int exponent) {
        if(exponent == 0){
            return 1;
        }
        if(exponent == 1){
            return base;
        }
        double result = Power2(base,exponent>>1);
        result *=result;
        if((exponent & 0x01) == 1){
            result *=base;
        }
        return result;
    }

    public double Power(double base, int exponent) {
        double sum = base;
        if(exponent< 0){
            return  1.0/Power(base,-exponent);
        }else if(exponent == 0){
            return 1;
        }else{
           Power2(base,exponent);
        }
        return sum;
    }
}
