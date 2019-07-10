var video = document.getElementById('video');
var canvas = document.getElementById('canvas');
var ctx = canvas.getContext('2d');
var width = video.width;
var height = video.height;
canvas.width = width;
canvas.height = height;
function liveVideo(){
    var URL = window.URL || window.webkitURL;   // 获取到window.URL对象
    navigator.getUserMedia({
        video: true
    }, function(stream){
        video.src = URL.createObjectURL(stream);   // 将获取到的视频流对象转换为地址
        video.play();   // 播放
        //点击截图     
        document.getElementById("snap").addEventListener('click', function() {
            ctx.drawImage(video, 0, 0, width, height);
            var url = canvas.toDataURL('image/png');
            document.getElementById('download').href = url;
        });
    }, function(error){
        console.log(error.name || error);
    });
}
document.getElementById("live").addEventListener('click',function(){
    liveVideo();
});

