//로또의 최고 순위와 최저 순위
function solution(lottos, win_nums) {
    let zeroNum = 0;
    let num = 0;
    lottos.map((el, index) => {
        if (el === 0) {
            zeroNum++;
        } else {
            if (win_nums.includes(el)) {
                num++;
            }
        }
    })
    
    let answer = [7-num-zeroNum, 7-num];
    
    if (!num) {
        answer[1] = 6;
        if (!zeroNum) {
            answer[0] = 6;
        }
    }
    return answer;
}