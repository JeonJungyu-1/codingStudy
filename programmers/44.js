//캐시
function solution(cacheSize, cities) {
    let cache = [];
    let cacheIndex;
    let answer = 0;
    if (cacheSize === 0) {
        return cities.length * 5;
    }
    cities.map(el => {
        el = el.toLowerCase();
        cacheIndex = cache.indexOf(el);
        if (cacheIndex !== -1) {
            cache.splice(cacheIndex, 1);
            answer += 1;
        } else {
            if (cache.length === cacheSize) {
                cache.shift();
            }
            answer += 5;    
        }
        cache.push(el);
    })
    return answer;
}