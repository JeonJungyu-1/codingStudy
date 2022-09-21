//위장
function solution(clothes) {
    let result = 1;
    let map = new Map();
    clothes.map((el, index) => {
        if (map.has(el[1])) {
            map.set(el[1], map.get(el[1]) + 1);
        } else {
            map.set(el[1], 1);
        }
    })
    
    for (let value of map.values()) {
        result *= (value + 1)
    }
    
    
    return result - 1;
}