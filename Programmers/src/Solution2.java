class Solution2 {
    public static int count,choice,best,worst;
    public int[] solution(int[] lottos, int[] win_nums) {
        for(int i = 0; i<6; i++){
            if(lottos[i]==0){
                choice++;
                continue;
            }
            for(int j= 0; j<6; j++){
                if(lottos[i]==win_nums[j])count++;
            }
        }
        switch(count+choice){
            case 6 : best = 1; break;
                        case 5 : best = 2; break;
                            case 4 : best = 3; break;
                            case 3 : best = 4; break;
                            case 2 : best = 5; break;
                            default : best = 6; break;
        }
                switch(count){
            case 6 : best = 1; break;
                        case 5 : worst = 2; break;
                            case 4 : worst = 3; break;
                            case 3 : worst = 4; break;
                            case 2 : worst = 5; break;
                            default : worst = 6; break;
        }
        int[] answer = {best,worst};
        return answer;
    }
}