//성격 유형 검사하기
function solution(survey, choices) {
    let answer = '';
    let scoreMap = new Map();
    const char = [["R", "T"], ["C", "F"], ["J", "M"], ["A", "N"]];
    char.map((el) => {
        scoreMap.set(el[0], 0);
        scoreMap.set(el[1], 0);
    });
    
    survey.map((el, index) => {
        if (choices[index] < 4) {
            scoreMap.set(el[0], scoreMap.get(el[0]) + 4 - choices[index]);
        } else if (choices[index] > 4) {
            scoreMap.set(el[1], scoreMap.get(el[1]) - 4 + choices[index]);
        }
    })
    
    char.map((el) => {
        if (scoreMap.get(el[0]) >= scoreMap.get(el[1])) {
            answer += el[0];
        } else {
            answer += el[1];
        }
    })
    return answer;
}