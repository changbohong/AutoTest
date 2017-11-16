<%--
  Created by IntelliJ IDEA.
  User: changbohong
  Date: 2017/10/30
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示页面树形结构</title>

    <!-- 引入 Bootstrap -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="../css/metroStyle/metroStyle.css">
    <script type="text/javascript" src="../js/jquery.ztree.all.min.js"></script>
</head>
<body>
    <div>
        <ul id="user_tree" class="zTree"></ul>
    </div>

    <script>
        function clickExpand(e, treeId, treeNode) {
            var zTreeObj = $.fn.zTree.getZTreeObj(treeId);
            zTreeObj.expandNode(treeNode);
        }

        var setting = {
            view: {
                fontCss:{'color':'black','font-weight':'bold'},  // 字体样式函数
                dblClickExpand: false
            },
            data: {
                simpleData: {
                    enable:true
                }
            },
            callback: {
                onClick: clickExpand
            }
        };

        var zNodes = ${zNodes};

        $(function(){
            $.fn.zTree.init($("#user_tree"), setting, zNodes);
        });

    </script>
</body>
</html>
