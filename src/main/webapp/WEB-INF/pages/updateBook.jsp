<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:template>
    <form:form method="post" action="/updateBook" commandName="ubook">
        <table>
            <tr>
                <td><form:label path="iD">
                    id
                </form:label></td>
                <td><form:input path="iD" value="${editBook.iD}"/></td>
            </tr>
            <tr>
                <td><form:label path="name">
                    Name
                </form:label></td>
                <td><form:input path="name" value="${editBook.name}"/></td>
                <td><form:errors cssClass="error" path="name"></form:errors></td>
            </tr>
            <tr>
                <td><form:label path="genre">
                    Genre
                </form:label></td>
                <td><form:input path="genre" value="${editBook.genre}"/></td>
                <td><form:errors cssClass="error" path="genre"></form:errors></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Update book"></td>
            </tr>
        </table>
    </form:form>
</t:template>
