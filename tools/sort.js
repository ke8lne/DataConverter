const fs = require("fs");

const data = fs.readFileSync("./data.txt", "utf-8");
let sorted = data.split("\t").map((a) => '"' + a.trim().split("\r\n")[0] + '"');
sorted.shift();

fs.writeFileSync("./data.txt", "{ " + sorted.join(", ") + " }");
