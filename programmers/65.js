//하샤드 수
function solution(x) {
    let answer = true;
    let sum = 0;
    let stringX = String(x);
    for (let i = 0; i < stringX.length; i++) {
        sum += Number(stringX[i]);
    }
    if (x % sum === 0) {
        answer = true;
    } else {
        answer = false;
    }
    return answer;
}