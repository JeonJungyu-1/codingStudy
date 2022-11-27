//오픈채팅방
function solution(record) {
    const answer = [];
    const id = new Map();
    const recordArr = []
    for (let i = 0; i < record.length; i++) {
        recordArr[i] = record[i].split(" ");
        if (recordArr[i][0] === "Enter" || recordArr[i][0] === "Change") {
            id.set(recordArr[i][1], recordArr[i][2]);
        }
    }
    
    for (let i = 0; i < recordArr.length; i++) {
        if (recordArr[i][0] === "Enter") {
            answer.push(`${id.get(recordArr[i][1])}님이 들어왔습니다.`);
        } else if (recordArr[i][0] === "Leave") {
            answer.push(`${id.get(recordArr[i][1])}님이 나갔습니다.`);
        }
    }
    return answer;
}