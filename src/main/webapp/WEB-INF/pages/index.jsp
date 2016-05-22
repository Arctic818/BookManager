<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<t:template>
    <c:if test = "${!empty books}">
        <table class="book-list-table">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Genre</th>
                <sec:authorize access="hasRole('user')">
                    <th>delete</th>
                </sec:authorize>
            </tr>
            <c:forEach items = "${books}" var = "book">
                <tr>
                    <td>${book.iD}</td>
                    <td>${book.name}</td>
                    <td>${book.genre}</td>
                    <sec:authorize access="hasRole('user')">
                        <td><a href="javascript:BookUtil2.editBook(${book.iD})">Edit</a>|<a href="javascript:BookUtil.deleteBook(${book.iD})">Delete</a>
                        </td>
                    </sec:authorize>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <br>
    
    <sec:authorize access="isAuthenticated()">
        <a href="addBook">Add book</a>
    </sec:authorize>

</t:template>