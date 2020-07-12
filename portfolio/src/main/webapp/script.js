// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

$( document ).ready(function() {
    fetch('/list-message').then(response => response.json()).then((messages) => {
        messages.forEach((message) => {
            $('#message_board').append(createMessageElement(message));
        });
    });

    $('#first_next').click(function(){
        $('html, body').animate({
            scrollTop: $("#second").offset().top
        }, 1500);
    });

    $('#education_btn').click(function(){
        $('html, body').animate({
            scrollTop: $("#education").offset().top
        }, 1000);
    });

    $('#work_btn').click(function(){
        $('html, body').animate({
            scrollTop: $("#work").offset().top
        }, 1000);
    });

    $('.detail_button').click(function(){
        $content = $(this).parent().next();        
        $content.slideToggle(500);
    });

    $('.detail_content').hide();

    $('#message_btn').click(function(){
        $('html, body').animate({
            scrollTop: $("#third").offset().top
        }, 1000);
    });
});

/** Creates an element that represents a message. */
function createMessageElement(message) {
    const message_name = document.createElement('div');
    message_name.className= 'message_name';
    message_name.innerText = message.username;
    const message_time = document.createElement('div');
    message_time.className= 'message_time';
    message_time.innerText = message.date;

    const message_last = document.createElement('div');
    message_last.className = 'message_last';
    message_last.appendChild(message_name);
    message_last.appendChild(message_time);

    const message_content = document.createElement('div');
    message_content.className = 'message_content';
    message_content.innerText = message.content;

    const message_list = document.createElement('div');
    message_list.className = 'message_list';
    message_list.appendChild(message_content);
    message_list.appendChild(message_last);

    const message_flex = document.createElement('div');
    message_flex.className = 'message_flex';
    message_flex.appendChild(message_list);

    return message_flex;
}