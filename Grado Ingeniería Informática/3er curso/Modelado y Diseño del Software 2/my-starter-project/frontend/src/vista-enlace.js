import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class VistaEnlace extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-horizontal-layout class="content" style="align-items: center;" id="vaadinHorizontalLayout">
 <label id="nombre_seccion" style="flex-grow: 1; align-self: stretch;"></label>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-enlace';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaEnlace.is, VistaEnlace);
