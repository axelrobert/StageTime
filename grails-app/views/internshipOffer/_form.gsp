<%@ page import="stagetime.WorkingSpace; stagetime.InternshipType; stagetime.InternshipOffer" %>

<div>
    <label for="title" >Title</label>
    <g:textField name="title" maxlength="30" />
</div>
<div>
    <label for="workingLocation" >Working Location</label>
    <g:textField name="workingLocation" maxlength="50" />
</div>
<div>
    <label for="salary" >Salary</label>
    <g:textField placeholder="Month net effective salary" name="salary"/>
</div>
<div>
    <label for="dateBegin" >Begin Date</label>
    <g:jqDatePicker name="dateBegin"/>
</div>
<div>
    <label for="monthDuration">Duration (in month)</label>
    <g:textField placeholder="Month duration" name="monthDuration"/>
</div>
<div>
    <label for="workingSpace">Working Space</label>
    <g:select from="${WorkingSpace.values()}" name="workingSpace" />
</div>
<div>
    <label for="internshipType">Internship Type</label>
    <g:select from="${InternshipType.values()}" name="internshipType" />
</div>
<div>
    <label for="tutor">Tutor</label>
    <g:textField name="tutor"/>
</div>
<div>
    <label for="filename">Upload your file (PDF)</label>
    <g:uploadForm name="filename">
        <input type="file" name="filename" />
    </g:uploadForm>
</div>