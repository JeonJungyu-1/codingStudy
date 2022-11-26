//압축
function solution(msg) {
    const answer = [];
    let dic = new Map();
    let lastIndex = 26;
    for (let i = 65; i < 91; i++) {
        dic.set(String.fromCharCode(i), i - 64);
    }

    const checkDic = (index, word) => {
        let preWord = word;
        let cnt = 1;
        while (1) {
            if (dic.has(word)) {
                preWord = word;

                //이 부분 slice 사용하면 속도 느림
                word += msg[index + cnt];
            } else {
                lastIndex++;
                dic.set(word, lastIndex);
                answer.push(dic.get(preWord));
                return cnt - 2;
            }
            cnt++;
        }
    };
    
    for (let i = 0; i < msg.length; i++) {
        let len = checkDic(i, msg[i]);
        i += len;
    }
    return answer;
}