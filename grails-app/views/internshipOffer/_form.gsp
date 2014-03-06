<%@ page import="stagetime.WorkingSpace; stagetime.InternshipType; stagetime.InternshipOffer" %>

<div>
    <label for="title" >Titre</label>
    <g:textField name="title" maxlength="30" value="${offerInstance?.title}" />
</div>
<div>
    <label for="workingLocation" >Lieu de travail</label>
    <g:textField name="workingLocation" maxlength="50" value="${offerInstance?.workingLocation}"/>
</div>
<div>
    <label for="salary" >Salaire</label>
    <g:textField placeholder="Month net effective salary" name="salary" value="${offerInstance?.salary}"/>
</div>
<div>
    <label for="dateBegin" >Date de début du stage</label>
    <g:jqDatePicker name="dateBegin" value="${offerInstance?.dateBegin}"/>
</div>
<div>
    <label for="monthDuration">Durée (en mois)</label>
    <g:textField placeholder="Month duration" name="monthDuration" value="${offerInstance?.monthDuration}"/>
</div>
<div>
    <label for="workingSpace">Environnement de travail</label>
    <g:select from="${WorkingSpace.values()}" name="workingSpace" value="${offerInstance?.workingSpace}"/>
</div>
<div>
    <label for="internshipType">Type du stage</label>
    <g:select from="${InternshipType.values()}" name="internshipType" value="${offerInstance?.internshipType}"/>
</div>
<div>
    <label for="tutor">Tuteur</label>
    <g:textField name="tutor" value="${offerInstance?.tutor}"/>
</div>
<div>
    <label for="filename">Déposer l'offre de stage (PDF)</label>
    <g:uploadForm name="filename">
        <input type="file" name="filename"/>
    </g:uploadForm>
</div>