import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import './vista-listapedidoscibernauta.js';

class VistaVerpedidos extends PolymerElement {

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
<vaadin-vertical-layout style="width: 100%; height: 100%;" id="vertical">
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-verpedidos';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaVerpedidos.is, VistaVerpedidos);
