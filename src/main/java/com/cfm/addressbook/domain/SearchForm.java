package com.cfm.addressbook.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchForm {

    private String query;

    public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	@Override
    public String toString() {
        return "SearchForm{" +
                "query='" + query + '\'' +
                '}';
    }
}
