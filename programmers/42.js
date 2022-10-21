//다음 큰 숫자
function solution(n) {
    var answer = n + 1;
    let nLength = n.toString(2).replaceAll("0", "").length;
    let answerLength;
    while(1) {
        answerLength = answer.toString(2).replaceAll("0", "").length;
        if (nLength === answerLength) {
            break;
        }
        answer++;
    }
    return answer;
}