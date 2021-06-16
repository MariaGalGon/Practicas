import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-select/src/vaadin-select.js';
import '@vaadin/vaadin-list-box/src/vaadin-list-box.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';

class VistaComun extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
        			padding: 0px;
        			margin: 0px;
                }
            </style>
<vaadin-vertical-layout style="align-items: stretch; width: 100%; height: 100%; padding: 0px; margin: 0px;" id="VerticalLayout"></vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-comun';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaComun.is, VistaComun);
