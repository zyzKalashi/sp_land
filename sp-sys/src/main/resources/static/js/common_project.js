function project_simpleList(queryData) {
	$.post("/project/simpleList", queryData, function(result) {
		console.log(result)
		if (result.code == 0) {
			return result.pageList.records;
		} else {
			layer.msg(result.msg);
		}
	});
}