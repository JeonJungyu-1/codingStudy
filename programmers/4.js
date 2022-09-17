//K번째 수
function solution(array, commands) {
    "use strict";
    
    let array2;
    let answer = [];
    function compare(a,b) {
        if (a>b) return 1;
        if (a==b) return 0;
        if (a<b) return -1;
    }
    for(let i = 0; i < commands.length; i++) {
        array2 = array.slice(commands[i][0]-1, commands[i][1]);
        array2.sort(compare);
        answer.push(array2[commands[i][2]-1]);
    }
    
    
    return answer;
}