import java.util.Arrays;

public class Fleets {
    public static void main(String[] args) {
        int position[] = {10,8,0,5,3}, speed[] = {2,4,6,1,3}, target = 12;

        Car cars[] = new Car[position.length];

        //allocating memory
        for(int i=0; i<position.length; i++) {
            cars[i] = new Car(position[i], (target - position[i])/speed[i]);
        }

        Arrays.sort(cars, (a,b) -> Integer.compare(a.pos, b.pos));

        int t = position.length-1, ans=0;
        while(t > 0) {
            //nothing overtakes the lead car
            if(cars[t].time < cars[t-1].time)
                ans++;
            else
                cars[t-1] = cars[t];
            t--;
        }

        ans += 1;

        System.out.println(ans);
    }
}
