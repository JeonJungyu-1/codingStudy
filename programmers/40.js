//영어 끝말잇기
function solution(n, words) {
    let answer = [];
    let minIndex;
    for (let i = 0; i < words.length; i++) {
        if (i + 1 !== words.length ) {
            if (words[i][words[i].length - 1] !== words[i + 1][0]) {
                if (minIndex <= i + 1) continue;
                minIndex = i + 1;
                answer = [(i + 1) % n + 1, parseInt((i + 1) / n) + 1];
            } else {
                let strIndex = words.indexOf(words[i], i + 1);
                if (strIndex !== -1) {
                    if (minIndex <= strIndex) continue;
                    minIndex = strIndex;
                    answer = [strIndex % n + 1, parseInt(strIndex / n) + 1];
                }
            }    
        }   
    }
    
    if (answer.length === 0 && words.length % n === 0) {
        return [0, 0];
    }
    
    return answer;
}