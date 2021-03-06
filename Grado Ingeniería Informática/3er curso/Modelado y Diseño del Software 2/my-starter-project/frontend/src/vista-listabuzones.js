import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import './vista-buzon.js';

class VistaListabuzones extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 50%;
        			padding: 0px;
                }
            </style>
<vaadin-vertical-layout id="vaadinVerticalLayout">
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-listabuzones';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaListabuzones.is, VistaListabuzones);
