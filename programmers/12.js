//n^2 배열 자르기
function solution(n, left, right) {
    let answer = [];
    let num;
    for (let i = left; i < right + 1; i++) {
        num = parseInt(i / n) > (i % n) ? (parseInt(i / n) + 1) : ((i % n) + 1);
        answer.push(num);
    }
    return answer;
}