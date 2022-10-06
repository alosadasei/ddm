<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="ddm.database.DBManager" %>
<%@page import="ddm.objects.*" %>
<%@page import="ddm.controllers.*" %>
<!DOCTYPE html>
<html>
	<%
		Game game = new Game();
		game.init("player1","player2");
	%>
	<head>
		<script>
			
		</script>
	</head>
	<body>
		<header>
			<div id="sides" style="float:left;">
				<div id="move_sides">
					<div id="move_logo" class="logo"></div>
					<div id="move_count" class="count"><%=game.getPlayer().getMovementSeals() %></div>
				</div>
				<div id="attack_sides">
					<div id="attack_logo" class="logo"></div>
					<div id="attack_count" class="count"><%=game.getPlayer().getAttackSeals() %></div>
				</div>
				<div id="deffense_sides">
					<div id="deffense_logo" class="logo"></div>
					<div id="deffense_count" class="count"><%=game.getPlayer().getDeffenseSeals() %></div>
				</div>
				<div id="magic_sides">
					<div id="magic_logo" class="logo"></div>
					<div id="magic_count" class="count"><%=game.getPlayer().getMagicSeals() %></div>
				</div>
				<div id="trick_sides">
					<div id="trick_logo" class="logo"></div>
					<div id="trick_count" class="count"><%=game.getPlayer().getTrickSeals() %></div>
				</div>
			</div>
		</header>
		<main>
		</main>
		<footer>
		</footer>
	</body>
</html>
