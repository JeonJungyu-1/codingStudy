//n진수 게임
function solution(n, t, m, p) {
    let answer = '';
    let preNum = 0;
    let num = "";
    while (1) {
        if (num.length > t * m) break;
        num += preNum.toString(n).toUpperCase();
        preNum++;
    }
    
    for (let i = 0; i < num.length; i++) {
        if (i % m === p - 1 && answer.length < t) {
            answer += num[i];
        }
    }
    return answer;
}