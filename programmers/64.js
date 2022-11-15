//이상한 문자 만들기
function solution(s) {
    let answer = '';
    let index = 1;
    s = s.toLowerCase();
    for (let i = 0; i < s.length; i++) {
        if (s[i] !== " ") {
            if (index % 2 === 1) {
                if (i === 0) {
                    s = s[i].toUpperCase() + s.slice(i+1);
                } else if (i === s.length - 1) {
                    s = s.slice(0, i) + s[i].toUpperCase();
                } else {
                    s = s.slice(0, i) + s[i].toUpperCase() + s.slice(i+1);
                }
            }
            index++;
        } else {
            index = 1;
        }
        
    }
    answer = s;
    return answer;
}