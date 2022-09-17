//완주하지 못한 선수
function solution(participant, completion) {
    let map = new Map();
    
    for(var i = 0; i < participant.length; i++) {
        if(!map.has(participant[i])) {
            map.set(participant[i], 1);
        }
        else {
            var j = map.get(participant[i]);
            map.delete(participant[i]);
            map.set(participant[i], ++j);
        }
        
    }
    
    
    for(var i = 0; i < completion.length; i++) {
        if(map.get(completion[i]) == 1) {
            map.delete(completion[i]);
        }
        else {
            var j = map.get(completion[i]);
            map.delete(completion[i]);
            map.set(completion[i], --j);
        }
    }
    
    for (let amount of map.keys()) {
        return amount;
    }
    
}