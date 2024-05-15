// import * as d3 from 'd3';
// import * as cloud from 'd3-cloud';
// <script>
//
//     var wordCloudData=[
//     {text:"许墨",size: 10},
//     {text:"夏彦",size: 9},
//     {text:"齐司礼",size: 8},
//     {text:"陆沉",size: 7}
//     ]
//
//     // 获取从后端传递到前端的普通列表数据
//     // <%--var wordList = ${impression.impression}; // 使用JSP的EL表达式替换成实际的列表数据--%>
//
//     // 计算每个词的出现次数
//     // var wordCloundData = {};
//     // wordList.forEach(function(word) {
//     //     if (wordCount[word]) {
//     //         wordCount[word] += 1;
//     //     } else {
//     //         wordCount[word] = 1;
//     //     }
//     // });
//     var wordCloudData = [];
//
//     Object.keys(wordList).forEach(function(word) {
//
//     var index = wordCloudData.findIndex(function(item) {
//     return item.text === word;
//     });
//
//     if (index !== -1) {
//     // 如果单词已经存在，则更新其大小属性
//     wordCloudData[index].size += 1;
//     } else {
//     // 否则，将新的单词对象添加到数组中
//     wordCloudData.push({ text: word, size: 1 });
// }
//     });
//     wordCloudData.push({text:"许墨",size:10})
//     <%--                    <% System.out.println(wordCloudData);%>--%>
//     //                     wordCloudData
//
//
//     // 获取容器元素
//     var container = d3.select("#wordcloud");
//
//                     // 创建词云布局
//                     var layout = d3.layout
//                         .cloud()
//                         // .size([500, 200])
//                         .words(wordCloudData)
//                         .padding(5)
//                         .rotate(function () {
//                             // return ~~(Math.random() * 2) * 90;
//                             return (~~(Math.random() * 6) - 3) * 30;
//                             // return 0;
//                         })
//                         .font("Impact")
//                         .fontSize(function (d) {
//                             return d.size;
//                         })
//                         .on("end", draw);
//
//                     // 设置每个单词的颜色
//                     layout.words().forEach(function (word) {
//                         word.color = getRandomColor();
//                     });
//
//                     // 绘制词云
//                     layout.start();
//
//                     //绘制函数
//                     function draw(words) {
//                         d3.select("body")
//                             .append("svg")
//                             .append("g")
//
//                             .selectAll("text")
//                             .data(words)
//                             .enter()
//                             .append("text")
//                             .style("font-size", function (d) {
//                                 return d.size + "px";
//                             })
//                             .style("font-family", "Impact")
//                             .style("fill", function (d) {
//                                 return d.color;
//                             }) // 设置每个单词的颜色
//                             .attr("text-anchor", "middle")
//                             .attr("transform", function (d) {
//                                 return "translate(" + [d.x, d.y] + ")rotate(" + d.rotate + ")";
//     })
//     .text(function (d) {
//     return d.text;
//     });
//     }
//
//     // 生成随机颜色
//     function getRandomColor() {
//     var letters = "0123456789ABCDEF";
//     var color = "#";
//     for (var i = 0; i < 6; i++) {
//     color += letters[Math.floor(Math.random() * 16)];
//     }
//     return color;
//     }
// </script>
const data = [
    {text: "apple", size: 32},
    {text: "orange", size: 24},
    {text: "banana", size: 16},
    {text: "watermelon", size: 8},
    {text: "grape", size: 4},
];

const layout = d3.layout.cloud()
    .size([800, 600])
    .words(data)
    .padding(5)
    .rotate(function() { return ~~(Math.random() * 2) * 90; })
    .font("Impact")
    .fontSize(function(d) { return d.size; })
    .on("end", draw);

layout.start();

function draw(words) {
    d3.select("#wordcloud")
        .append("svg")
        .attr("width", layout.size()[0])
        .attr("height", layout.size()[1])
        .append("g")
        .attr("transform", "translate(" + layout.size()[0] / 2 + "," + layout.size()[1] / 2 + ")")
        .selectAll("text")
        .data(words)
        .enter().append("text")
        .style("font-size", function(d) { return d.size + "px"; })
        .style("font-family", "Impact")
        .style("fill", function(d, i) { return d3.schemeCategory10[i % 10]; })
        .attr("text-anchor", "middle")
        .attr("transform", function(d) {
            return "translate(" + [d.x, d.y] + ")rotate(" + d.rotate + ")";
        })
        .text(function(d) { return d.text; });
};