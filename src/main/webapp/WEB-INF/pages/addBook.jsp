<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<t:template>
    <form:form method="POST" action="addBook" commandName="book">
        <table>
            <tr>
                <td><form:label path="name">
                    Name
                </form:label></td>
                <td><form:input path="name" /></td>
                <td><form:errors cssClass="error" path="name"></form:errors></td>
            </tr>
            <tr>
                <td><form:label path="genre">
                    Genre
                </form:label></td>
                <td><form:input path="genre" /></td>
                <td><form:errors cssClass="error" path="genre"></form:errors></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Add book"></td>
            </tr>
        </table>
    </form:form>
</t:template>
