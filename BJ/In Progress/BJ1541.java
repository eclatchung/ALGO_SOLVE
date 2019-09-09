import java.util.*;
//===============TO DO================
// 오류 발생하는 문장 60-70+85-40
// 이거 해결해야한다.
public class BJ1541 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String exp = scan.nextLine();
        char[] expArr = exp.toCharArray();
        String[] mainCal = new String[50];
        int result =0;
        int index =0;
        int tmpM =0;
        int k =-1;

        //연산자들과 숫자들을 mainCal에 차곡차곡 쌓음.
        for(int i=1;i<=expArr.length;i++){
            if(i==expArr.length) {
                char[] tmpArr = new char[i-index];
                for(int j=0,i1 = index;j<(i-index)&i1<i;i1++,j++){
                    tmpArr[j]= expArr[i1];
                }
                String tmpS = new String(tmpArr);
                mainCal[++k] =tmpS;
            }else if(expArr[i]=='+'||expArr[i]=='-'){
                char[] tmpArr = new char[i-index];
                for(int j=0,i1 = index;j<(i-index);i1++,j++){
                    tmpArr[j]= expArr[i1];
                }
                String tmpS = new String(tmpArr);
                mainCal[++k] =tmpS;
                mainCal[++k]=Character.toString(expArr[i]);
                index = i+1;
            }
        }
        //k의 값 +1가 연산자랑 숫자 갯수임
        String[] RealExp = new String[k+1];
        for(int i=0;i<k+1;i++) RealExp[i] =mainCal[i];

        int t=0;


        result=Integer.parseInt(RealExp[0]);
        for(int i=1;i<k;i+=2){
            if(RealExp[i].equals("-")){
                if((i+2)>k) {
                    result-=Integer.parseInt(RealExp[i+1]);
                    break;
                }
                for(int j=i+2;j<k;j+=2){
                    if(RealExp[j].equals("-")){
                        result-=tmpM;
                        tmpM=0;
                        i=j-2;
                        break;
                    }
                    else{
                        tmpM+=Integer.parseInt(RealExp[j-1]);
                    }
                    if(j==k-1){
                            t++;
                            result-=(Integer.parseInt(RealExp[j+1])+tmpM);
                            break;
                    }
                }
            }
            else if(t==0&&RealExp[i].equals("+")){
                result+=Integer.parseInt(RealExp[i-1]);
            }else if(t==0&&i==k-1){
                result += Integer.parseInt(RealExp[i-1]);
                break;
            }else break;

        }
        System.out.println(result);

    }
}