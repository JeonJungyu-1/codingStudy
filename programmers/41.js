//짝지어 제거하기
//1 효율성 안됨
function solution(s) {
    
    for (let i = 0; i < s.length; i++) {
        if (i + 1 !== s.length && s[i] === s[i + 1]) {
            s = s.replaceAll(s[i] + s[i], "");
            i -= 2;
        }
    }
    

    return s.length ? 0 : 1;
}

//2 효율성도 통과
function solution(s) {
    let stack = [s[0]];
    for (let i = 1; i < s.length; i++) {        
        if (stack[stack.length - 1] === s[i]) {
            stack.pop();
        } else {
            stack.push(s[i]);
        }
    }

    return stack.length ? 0 : 1;
}