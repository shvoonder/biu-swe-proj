<form method='post'>
  NAME:<br/>
   <input type='text' name='name' id='name' /><br />

  Comment: </br>
  <textarea name='comment' id='comment'></textarea><br />

  <input type='hidden' name='articleid' id='articleid' value='<? echo $_GET["id"]; ?>' />

  <input type='submit' value='Submit' />
</form>
