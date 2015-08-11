/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2015
 * --------------------------------------------------------------------------- */
$(document).ready(function() {
	retrieveTweetList();
	
	//Add Tweet
	$('#btnTweet').click(function() {
		$('#errorDisplay').empty();
		$('.updateErrorDisplay').empty();

		jsonData = {
				data: JSON.stringify({
				content: $('#txtContent').val(),
				})
		};
		
		$.ajax({
			url: 'tweet',
			type: 'POST',
			data: jsonData,
			dataType: 'json',
			success: function(data, status, jqXHR){
				if(data.errorList.length == 0) {
					$('#txtContent').val('');
					retrieveTweetList('Entry saved successfully!');
				} else {
					var msg = "";
					for (var i = 0; i < data.errorList.length; i++)
						msg += data.errorList[i] + "\n";
					$('#errorDisplay').html(msg);
				}
			},
			error: function(jqXHR, status, error) {
				
			}
		});
	});
	
	//Delete Tweet
	$(document).on('click', '#tweetList .btnDelete', function(){
		$('#errorDisplay').empty();
		$('.updateErrorDisplay').empty();
		
		//var errorDisplay = '';//TODO: (optional) use jQuery traversals to get the correct updateErrorDisplay div.
		var errorDisplay = $(this).siblings().filter('.updateErrorDisplay');
		
		//var idValue = '';//TODO: use jQuery traversals to get correct id value to be passed in json object.
		var idValue = $(this).siblings().filter('.id').val();

		//var contentValue = '';//TODO: use jQuery traversals to get correct content value to be passed in json object.
		var contentValue = $(this).siblings().filter('.content').val();
		
		//var createdDateValue = '';//TODO: use jQuery traversals to get correct createdDate value to be passed in json object.
		var createdDateValue = $(this).siblings().filter('.createdDate').val();
		
		jsonData = {
				data: JSON.stringify({
					id: idValue,
					content: contentValue,
					createdDate: createdDateValue,
				})
		};
		
		$.ajax({
			url: 'delete',//TODO: Provide proper url to call for deleting a tweet
			type: 'POST',
			data: jsonData,
			dataType: 'json',
			success: function(data, status, jqXHR){
				if(data.errorList.length == 0) {
					retrieveTweetList('Entry deleted successfully!');
				} else {
					var msg = "";
					for (var i = 0; i < data.errorList.length; i++) {
						msg += data.errorList[i] + "\n";
					}
					//TODO: (optional) use the errorDisplay to display the msg string there.
				}
			},
			error: function(jqXHR, status, error) {
				
			}
		});
	});
	
	//Update Tweet
	$(document).on('click', '#tweetList .btnUpdate', function(){
		//TODO: code jQuery code for updating tweet. hint: refer to your code for deleting tweets.
		$('#errorDisplay').empty();
		$('.updateErrorDisplay').empty();
		
		var errorDisplay = $(this).siblings().filter('.updateErrorDisplay');
		var idValue = $(this).siblings().filter('.id').val();
		var contentValue = $(this).siblings().filter('.content').val();
		var createdDateValue = $(this).siblings().filter('.createdDate').val();
		
		jsonData = {
				data: JSON.stringify({
					id: idValue,
					content: contentValue,
					createdDate: createdDateValue,
				})
		};
		
		$.ajax({
			url: 'update',
			type: 'POST',
			data: jsonData,
			dataType: 'json',
			success: function(data, status, jqXHR){
				if(data.errorList.length == 0) {
					retrieveTweetList('Entry updated successfully!');
				} else {
					var msg = "";
					for (var i = 0; i < data.errorList.length; i++)
						msg += data.errorList[i] + "\n";
					errorDisplay.html(msg);
				}
			},
			error: function(jqXHR, status, error) {
				
			}
		});
	});
	
	
});

/**
 * Method used to retrieve list of tweets.
 * @param successMessage - success message to display
 * 		if the transaction is successful.
 */
function retrieveTweetList(successMessage) {
	$("#tweetList").empty();
	$.ajax({
		url: 'list',
		type: 'GET',
		data: null,
		success: function(data, status, jqXHR){
			if(data.errorList.length == 0) {
				var formattedTweetList = "";
				$.each(data.tweetList, function(index, value) {
					formattedTweetList += '<hr />' +
						'<div class="tweetRow">' +
						'	<textarea name="content" class="content">' + value.content + '</textarea>' + value.createdDate +
						'	<input type="hidden" class="id" name="id" value="' + value.id + '"/>' +
						'	<input type="hidden" class="createdDate" name="createdDate" value="' + value.createdDate + '"/>' +
						'	<button class="btnUpdate">Save</button>' +
						'	<button class="btnDelete">Delete</button>' +
						'	<div class="updateErrorDisplay"></div>' +
						'</div>';
				});
				if (formattedTweetList == "") {
					formattedTweetList = "<div>Add tweets! :)</div>";
				}
				$("#tweetList").html(formattedTweetList);
				if (undefined != successMessage && "" != successMessage) {
					alert(successMessage);
				}
			} else {
				alert('Failed to retreive tweets!');
			}
		},
		error: function(jqXHR, status, error) {
			
		}
	});
}