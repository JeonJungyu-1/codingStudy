//3진법 뒤집기
function solution(n) {
    let answer = parseInt(n.toString(3).split("").reverse().join(""), 3);
    return answer;
}