//다트 게임
function solution(dartResult) {
    let answer = 0;
    let answerArr = [];
    let num;
    let bonus;
    for (let i = 0; i < dartResult.length; i++) {
        if (!isNaN(dartResult[i])) {
            if (dartResult[i] === "1" && dartResult[i + 1] === "0") {
                num = 10;
                i++;
            } else {
                num = Number(dartResult[i]);
            }
                        
            if (dartResult[i + 1] === "S") {
                bonus = 1;                
            } else if (dartResult[i + 1] === "D") {
                bonus = 2;
            } else if (dartResult[i + 1] === "T") {
                bonus = 3;
            }
            
            if (dartResult[i + 2] === "*") {
                answerArr.push(2 * Math.pow(num, bonus));
                if (answerArr.length !== 1) {
                    answerArr[answerArr.length - 2] *= 2;
                }
            } else if (dartResult[i + 2] === "#") {
                answerArr.push(-1 * Math.pow(num, bonus));
            } else {
                answerArr.push(Math.pow(num, bonus));
            }
        }
    }
    
    for (value of answerArr) {
        answer += value;
    }
    return answer;
}