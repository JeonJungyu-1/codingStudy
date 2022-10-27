//자연수 뒤집어 배열로 만들기
function solution(n) {
    let answer = [...n.toString()].reverse().map(el => +el);
    return answer;
}