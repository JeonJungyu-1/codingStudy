//괄호 회전하기
function solution(s) {
    var answer = 0;
    let left = ["(", "[", "{"];
    let right = [")", "]", "}"];
    let arr = [];
    let isAnswer = true;
    
    for (let i = 0; i < s.length; i++) {
        s = s.slice(1) + s[0];
        isAnswer = true;
        for (let j = 0; j < s.length; j++) {
            if (right.includes(s[j])) {
                if (right[arr[arr.length - 1]] === s[j]) {
                    arr.pop();
                } else {
                    isAnswer = false;
                    break;
                }
            } else {
                arr.push(left.indexOf(s[j]));
            }
        }
        if (isAnswer && !arr.length) {
            answer++;
        }
    }
    
    return answer;
}