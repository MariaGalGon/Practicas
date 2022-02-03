import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class VistaVermensajes extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                     display: block;
                    height: 100%;
        			width: 100%;
        			padding: 0px;
                }
            </style>
<vaadin-horizontal-layout class="content" id="vaadinHorizontalLayout">

</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-vermensajes';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaVermensajes.is, VistaVermensajes);
