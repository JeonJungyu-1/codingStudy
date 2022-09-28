//주차 요금 계산
function solution(fees, records) {
    let answer = [];
    let obj = [];
    let finalTime = calTime(23, 59);
    let cnt = 0;
    records.sort(sortFunc);
    let preValue = records[0].slice(6, 10);

    records.map((el, index) => {
        const [time, carNum, type] = el.split(" ");
        const [hour, minute] = time.split(":");
        if (carNum !== preValue) {
            preValue = carNum;
            cnt++;
        } 
        if (obj[cnt]) {
            if (type === "IN") {
                obj[cnt] = [obj[cnt][0], type, calTime(hour, minute)];
            } else {
                obj[cnt] = [calTime(hour, minute) - obj[cnt][2] + obj[cnt][0], type, 0];
            }
        } else {
            obj[cnt] = [0, type, calTime(hour, minute)];
        }
    })
    for (let key in obj) {
        if (obj[key][1] === "IN") {
            obj[key] = [finalTime - obj[key][2] + obj[key][0], "OUT", 0];
        } 
        answer.push(calFee(fees, obj[key][0]));
    }
    return answer;
}

function sortFunc(a, b) {
    let aTmp = a.slice(6, 10);
    let bTmp = b.slice(6, 10);
    if (aTmp < bTmp) return -1;
    else if (aTmp === bTmp) return 0;
    else return 1;
}

function calTime(hour, minute) {
    return Number(hour) * 60 + Number(minute);
}

function calFee(fees, time) {
    let def = time - fees[0];
    if (def <= 0) {
        return fees[1]
    } else {
        return Math.ceil(def / fees[2]) * fees[3] + fees[1];
    }
}