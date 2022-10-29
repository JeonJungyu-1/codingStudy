//내적
function solution(a, b) {
    let answer = a.reduce((sum, current, index) => sum + (current * b[index]), 0);
    return answer;
}