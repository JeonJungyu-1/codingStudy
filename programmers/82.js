//정수 제곱근 판별
function solution(n) {
    let answer = -1;
    let sqrtNum = Math.sqrt(n);
    if (Number.isInteger(sqrtNum)) {
        answer = Math.pow(sqrtNum + 1, 2);
    }
    return answer;
}